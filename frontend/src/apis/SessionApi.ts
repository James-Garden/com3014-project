import axios from '@/axios';
import type { AxiosResponse } from 'axios';
import type { GenericException } from '@/apis/ValidationUtil';
import type { User } from '@/apis/UserApi';

export class SessionApi {
  static async createSession(email: string, password: string): Promise<User | GenericException> {
    const response: AxiosResponse<User | GenericException, any> = await axios.post(
        '/session',
        { email, password },
        {
          validateStatus: (status) => (status === 200 || status === 401),
          withCredentials: true
        }
    );

    return response.data;
  }
}
