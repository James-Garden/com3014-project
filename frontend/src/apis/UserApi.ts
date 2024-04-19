import axios from '@/axios';
import type { AxiosResponse } from 'axios';
import type { ValidationFailedResponse } from '@/apis/ValidationUtil';

export class UserApi {
  static async createUser(username: string, email: string, password: string): Promise<ValidationFailedResponse | User> {
    const response: AxiosResponse<ValidationFailedResponse | User, any> = await axios.post(
        '/user',
        { username, email, password },
        { validateStatus: (status) => (status === 201 || status === 400) }
    );

    return response.data;
  }
}

export interface User {
  id: number,
  username: string,
  email: string
}
