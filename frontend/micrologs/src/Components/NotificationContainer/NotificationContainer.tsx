import { useEffect, useState } from "react";
import { webSocketService } from "../../Service/WebSockerService";
import Notification from "../Notification/Notification";
import "./notificationContainer.css";

type notificationProps = {
    className: String | null;
    notificationToggle: React.Dispatch<React.SetStateAction<boolean>>;
};

const NotificationContainer = (props: notificationProps) => {
    const [notificationList, setNotificationList] = useState<string[]>([]);

    const generateList = () => {
        let i = 0;
        return notificationList.map((notification) => (
            <Notification notification={notification} key={i++}></Notification>
        ));
    };

    const setNotificationVisibilityFalse = () => {
        props.notificationToggle(false);
    };

    useEffect(() => {
        webSocketService.connect();
        webSocketService.subscribe((message) => {
            setNotificationList((prev) => [...prev, JSON.stringify(message)]);
        });
    }, []);

    return (
        <div
            className={"notification-disabler " + props.className}
            onClick={setNotificationVisibilityFalse}
        >
            <div className={"notification-modal outline " + props.className}>
                <div className="notification-arrow outline"></div>
                <div className="notification-container"> {generateList()}</div>
            </div>
        </div>
    );
};

export default NotificationContainer;
