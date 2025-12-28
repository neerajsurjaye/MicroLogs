import { useContext, useEffect, useState } from "react";
import Notification from "../Notification/Notification";
import "./notificationContainer.css";
import LoginState from "../../State/LoginState";
import NotificationService from "../../Service/NotificationService";
// import { webSocketService } from "../../Service/WebSockerService";

type notificationProps = {
    className?: String | null;
};

const NotificationContainer = (props: notificationProps) => {
    const [notificationList, setNotificationList] = useState<any>([]);
    const [showNotification, setShowNotification] = useState<boolean>(false);
    const [loginState, setLoginState] = useContext(LoginState);

    const toggleNotification = () => {
        setShowNotification((prev) => !prev);
    };

    const getNotificationClass = (): string => {
        return showNotification ? "appear" : "disappear";
    };

    const setNotificationVisibilityFalse = () => {
        setShowNotification(false);
    };

    const generateList = () => {
        let i = 0;
        if (notificationList?.map)
            return notificationList.map((notification: any) => (
                <Notification
                    title={notification.title}
                    description={notification.description}
                    time={notification.emmited_at}
                    key={i++}
                ></Notification>
            ));
    };

    const fetchNotifications = async () => {
        console.log(
            "Fetching user notification : ",
            loginState.loggedin,
            loginState.userid
        );

        if (loginState.loggedin && loginState.userid) {
            let reqNotificatoins =
                await NotificationService.getNotificationForUser(
                    loginState.userid
                );

            setNotificationList(reqNotificatoins);
        }
    };

    useEffect(() => {
        fetchNotifications();
    }, [loginState]);

    return (
        <div className="notification-wrapper">
            <div className="notification-btn btn" onClick={toggleNotification}>
                Notification
            </div>
            <div
                className={
                    "notification-modal outline " + getNotificationClass()
                }
            >
                <div className="notification-arrow outline"></div>
                <div className="notification-container"> {generateList()}</div>
            </div>
        </div>
    );
};

export default NotificationContainer;
