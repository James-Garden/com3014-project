import { defineStore } from 'pinia';
import { type Ref, ref } from 'vue';
import { type User, UserApi } from '@/apis/UserApi';
import type { ValidationError } from '@/apis/ValidationUtil';
import { SessionApi } from '@/apis/SessionApi';

export const useUserStore = defineStore('user', () => {

  const currentUser: Ref<User | undefined> = ref();

  async function signUp(username: string, email: string, password: string): Promise<ValidationError[]> {
    const result = await UserApi.createUser(username, email, password);

    if ('errors' in result) {
      return result.errors;
    }

    currentUser.value = result;
    await SessionApi.createSession(email, password);

    return [];
  }

  async function signIn(email: string, password: string): Promise<boolean> {
    const response = await SessionApi.createSession(email, password);
    const wasSuccessful = 'id' in response;
    if (wasSuccessful) {
      currentUser.value = response;
    }

    return wasSuccessful;
  }

  return { signUp, signIn, currentUser };

});
