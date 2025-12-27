import "./notification.css";

type notificationProps = {
    description: string;
    title: string;
    time: string;
};

const Notification = (props: notificationProps) => {
    let time = new Date(props.time).toLocaleString("en-US", {
        dateStyle: "short",
        timeStyle: "short",
    });

    return (
        <div className="notification">
            <div className="notification-title">{props.title}</div>
            <div className="notification-body">{props.description}</div>

            <div className="notification-time">{time}</div>
        </div>
    );
};

export default Notification;
