import { createContext, type Dispatch, type SetStateAction } from "react";
import type { UserLoginState } from "../Types/UserLoginState";

const LoginState = createContext<
    [UserLoginState, Dispatch<SetStateAction<UserLoginState>>]
>([{ username: "", userid: "", loggedin: false }, () => {}]);

export default LoginState;
