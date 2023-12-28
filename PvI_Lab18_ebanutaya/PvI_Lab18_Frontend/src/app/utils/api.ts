import axios, { AxiosInstance } from 'axios';

export class Api {
    private static instance: Api;
    private api: AxiosInstance;

    constructor() {
        this.api = axios.create({
            baseURL: 'http://localhost:8081/PvI_Lab18_war_exploded/api',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': 'Content-Type, Accept, x-session-id, remember-me',
                'Access-Control-Allow-Credentials': 'true',
            },
            withCredentials: true
        });
    }

    public static getInstance(): Api {
        if (!Api.instance) {
            Api.instance = new Api();
        }
        return Api.instance;
    }

    public async get(url: string, params?: any) {
        try {
            const { data, headers } = await this.api.get(url, { params });
            if (headers['x-session-id'] && headers['x-session-id'] !== sessionStorage.getItem('sessionId')) {
                sessionStorage.setItem('sessionId', headers['x-session-id']);
            }
            return data;
        } catch (error: any) {
            if (error.response) {
                console.error(`Error ${error.response.status}: ${error.response.data.message}`);
            }
            throw error;
        }
    }

    public async post(url: string, data?: any) {
        try {
            const { headers } = await this.api.post(url, data);
            if (headers['x-session-id'] && headers['x-session-id'] !== sessionStorage.getItem('sessionId')) {
                sessionStorage.setItem('sessionId', headers['x-session-id']);
            }
        } catch (error: any) {
            if (error.response) {
                console.error(`Error ${error.response.status}: ${error.response.data.message}`);
            }
            throw error;
        }
    }

    public async put(url: string, data?: any) {
        try {
            await this.api.put(url, data);
        } catch (error: any) {
            if (error.response) {
                console.error(`Error ${error.response.status}: ${error.response.data.message}`);
            }
            throw error;
        }
    }

    public async delete(url: string) {
        try {
            await this.api.delete(url);
        } catch (error: any) {
            if (error.response) {
                console.error(`Error ${error.response.status}: ${error.response.data.message}`);
            }
            throw error;
        }
    }
}
