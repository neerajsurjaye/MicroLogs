import { JWT_TOKEN } from "../Constants/Constants";

class FetchService {
    public static async get(url: string, headers: any): Promise<any> {
        let requestHeaders = {};

        if (localStorage.getItem(JWT_TOKEN) != null) {
            requestHeaders = {
                ...requestHeaders,
                Authorization: `Bearer ${localStorage.getItem(JWT_TOKEN)}`,
            };
        }
        if (headers != null) requestHeaders = { ...requestHeaders, ...headers };

        const resp = await fetch(url, { headers: requestHeaders });
        const json = await resp.json();

        return json;
    }

    public static async post(
        url: string,
        body: string,
        headers: any | null
    ): Promise<any> {
        let response: Response | null = null;

        let requestHeaders = {
            "Content-Type": "application/json",
        };

        if (headers != null) {
            requestHeaders = { ...requestHeaders, ...headers };
        }

        response = await fetch(url, {
            method: "POST",
            body: body,
            headers: requestHeaders,
        });

        return await response.json();
    }

    public static getAuthHeader(): any {
        return { Authorization: `Bearer ${localStorage.getItem(JWT_TOKEN)}` };
    }
}

export default FetchService;
