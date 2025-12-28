import { GATEWAY_URL } from "../Constants/Constants";
import FetchService from "./FetchService";

class AuthenticationService {
    public static async login(
        username: string,
        password: string
    ): Promise<any | null> {
        console.log("Login");
        const signUpUrl = `${GATEWAY_URL}/auth/api/v1/user/login`;
        const body = { username, password };
        console.log("Body :: ", body);

        const resp = await FetchService.post(
            signUpUrl,
            JSON.stringify(body),
            null
        );

        if (resp.status) {
            // Pop Up Modal
            console.log(`SignUp :: ${JSON.stringify(resp)}`);
            return resp?.data || null;
        } else {
            // Pop up modal
            console.log(`SignUp issue ${JSON.stringify(resp)}`);
            return null;
        }
    }

    public static async signup(username: string, password: string) {
        console.log("Sign Up");
        const signUpUrl = `${GATEWAY_URL}/auth/api/v1/user`;
        const body = { username, password };

        const resp = await FetchService.post(
            signUpUrl,
            JSON.stringify(body),
            null
        );

        if (resp.status) {
            // Pop Up Modal
            console.log(`SignUp :: ${JSON.stringify(resp)}`);
        } else if (resp.message && !resp.status) {
            // Pop up modal
            console.log(`SignUp issue ${JSON.stringify(resp)}`);
        }
    }
}

export default AuthenticationService;
