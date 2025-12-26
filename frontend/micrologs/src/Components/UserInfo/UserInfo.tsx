import "./userinfo.css";

type username = {
    username: string;
};

const UserInfo = (props: username) => {
    return <div className="user-info">{props.username}</div>;
};

export default UserInfo;
