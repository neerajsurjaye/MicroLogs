import { useEffect, useState } from "react";
import { webSocketService } from "../../Service/WebSockerService";
import Notification from "../Notification/Notification";
import "./notificationContainer.css";

type notificationProps = {
    className?: String | null;
};

const NotificationContainer = (props: notificationProps) => {
    const [notificationList, setNotificationList] = useState<string[]>([]);

    const [showNotification, setShowNotification] = useState<boolean>(false);

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
        return notificationList.map((notification) => (
            <Notification notification={notification} key={i++}></Notification>
        ));
    };

    useEffect(() => {
        webSocketService.connect();
        webSocketService.subscribe((message) => {
            setNotificationList((prev) => [...prev, JSON.stringify(message)]);
        });
    }, []);

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
