import { Link } from "react-router";
import "./navbar.css";
import NotificationContainer from "../NotificationContainer/NotificationContainer";
import { useState } from "react";

const NavBar = () => {
    const [showNotification, setShowNotification] = useState<boolean>(false);

    const toggleNotification = () => {
        setShowNotification((prev) => !prev);
    };

    const getNotificationClass = (): string => {
        return showNotification ? "appear" : "disappear";
    };

    return (
        <div className="navbar outline">
            <div className="logo">
                <Link to={"/"}>Logo</Link>
            </div>

            <div className="nav-buttons">
                <div
                    className="notification-btn btn"
                    onClick={toggleNotification}
                >
                    Notification
                </div>

                <div className="btn">
                    <Link to={"/auth"}>Auth</Link>
                </div>

                <div className="btn">btn</div>
            </div>
            <NotificationContainer
                className={getNotificationClass()}
                notificationToggle={setShowNotification}
            ></NotificationContainer>
        </div>
    );
};

export default NavBar;
