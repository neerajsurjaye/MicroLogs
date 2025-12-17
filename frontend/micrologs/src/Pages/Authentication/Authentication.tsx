import { useState } from "react";
import LabelledInput from "../../Components/LabelledInput/LabelledInput";
import "./authentication.css";
import Button from "../../Components/Button/Button";

const Authentication = () => {
    let [username, setUsername] = useState("");
    let [password, setPassword] = useState("");

    return (
        <div className="auth-page">
            <div>
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
            <div>
                <Button label="Login"></Button>
                <Button label="SignUp"></Button>
            </div>
        </div>
    );
};

export default Authentication;
