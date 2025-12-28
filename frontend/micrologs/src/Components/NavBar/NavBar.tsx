import { Link } from "react-router";
import "./navbar.css";
import NotificationContainer from "../NotificationContainer/NotificationContainer";
import { useContext } from "react";
import LoginState from "../../State/LoginState";
import { JWT_TOKEN, USERID, USERNAME } from "../../Constants/Constants";

const NavBar = () => {
    const [loginState, setLoginState] = useContext(LoginState);

    const logOut = () => {
        localStorage.removeItem(JWT_TOKEN);
        localStorage.removeItem(USERNAME);
        localStorage.removeItem(USERID);
        setLoginState({ username: "", userid: "", loggedin: false });
    };

    const getAuthBtn = () => {
        console.log("Get Auth Btn's ", loginState);

        if (loginState.loggedin == false) {
            return <Link to={"/auth"}>Auth</Link>;
        }

        return <div onClick={logOut}>Logout</div>;
    };

    return (
        <div className="navbar outline">
            <div className="logo">
                <Link to={"/"}>MicroLogs</Link>
            </div>

            <div className="nav-buttons">
                <NotificationContainer></NotificationContainer>

                <div className="btn">{getAuthBtn()}</div>

                <div className="btn">
                    <Link to={"/create"}>Create Article</Link>
                </div>
            </div>
        </div>
    );
};

export default NavBar;
