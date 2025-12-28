import { useContext, useState } from "react";
import LabelledInput from "../../Components/LabelledInput/LabelledInput";
import "./authentication.css";
import Button from "../../Components/Button/Button";
import AuthenticationService from "../../Service/AuthenticationService";
import { JWT_TOKEN, USERID, USERNAME } from "../../Constants/Constants";
import LoginState from "../../State/LoginState";

const Authentication = () => {
    let [username, setUsername] = useState("");
    let [password, setPassword] = useState("");
    let [loginState, setLoginState] = useContext(LoginState);

    const handleLogin = async () => {
        console.log("Handling Login");

        const resp = await AuthenticationService.login(username, password);

        if (resp != null) {
            const token = resp.accessToken;
            const username = resp.username;
            const userid = resp.userid;

            console.log("JWT TOKEN", resp);
            localStorage.setItem(JWT_TOKEN, token);
            localStorage.setItem(USERNAME, username);
            localStorage.setItem(USERID, userid);
            setLoginState({ username, userid, loggedin: true });
        }
    };

    return (
        <div className="auth-page">
            <div className="auth-card">
                <h2>Authenticate</h2>
                <div className="auth-inputs">
                    <LabelledInput
                        label={"UserName"}
                        state={username}
                        setState={setUsername}
                    ></LabelledInput>

                    <LabelledInput
                        label={"Password"}
                        state={password}
                        setState={setPassword}
                    ></LabelledInput>
                </div>

                <div className="auth-btns">
                    <Button
                        className="btn"
                        label="Login"
                        onClick={() => {
                            handleLogin();
                        }}
                    ></Button>

                    <Button
                        className="btn"
                        label="SignUp"
                        onClick={() => {
                            AuthenticationService.signup(username, password);
                        }}
                    ></Button>
                </div>
            </div>
        </div>
    );
};

export default Authentication;
