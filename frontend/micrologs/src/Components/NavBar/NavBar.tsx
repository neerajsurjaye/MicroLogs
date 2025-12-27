import { Link } from "react-router";
import "./navbar.css";
import NotificationContainer from "../NotificationContainer/NotificationContainer";

const NavBar = () => {
    return (
        <div className="navbar outline">
            <div className="logo">
                <Link to={"/"}>MicroLogs</Link>
            </div>

            <div className="nav-buttons">
                <NotificationContainer></NotificationContainer>

                <div className="btn">
                    <Link to={"/auth"}>Auth</Link>
                </div>

                <div className="btn">
                    <Link to={"/create"}>Create Article</Link>
                </div>
            </div>
        </div>
    );
};

export default NavBar;
