import { useState } from "react";
import LabelledInput from "../../Components/LabelledInput/LabelledInput";
import "./authentication.css";
import Button from "../../Components/Button/Button";

const Authentication = () => {
    let [username, setUsername] = useState("");
    let [password, setPassword] = useState("");

    return (
        <div className="auth-page">
            <div className="auth-card">
                <h2>Authenticate</h2>
                <div className="auth-inputs">
                    <LabelledInput<string>
                        label={"UserName"}
                        state={username}
                        setState={setUsername}
                    ></LabelledInput>

                    <LabelledInput<string>
                        label={"Password"}
                        state={password}
                        setState={setPassword}
                    ></LabelledInput>
                </div>
                <div className="auth-btns">
                    <Button className="btn" label="Login"></Button>
                    <Button className="btn" label="SignUp"></Button>
                </div>
            </div>
        </div>
    );
};

export default Authentication;
