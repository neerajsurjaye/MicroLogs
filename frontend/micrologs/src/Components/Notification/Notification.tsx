type notificationProps = {
    notification: string;
};

const Notification = (props: notificationProps) => {
    return <div className="notification">{props.notification}</div>;
};

export default Notification;
