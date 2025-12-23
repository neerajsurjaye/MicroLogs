import ArticleContainer from "../../Components/ArticleContainer/ArticleContainer";
import UserInfo from "../../Components/UserInfo/UserInfo";
import "./UserPage.css";

const UserPage = () => {
    return (
        <div className="user-page layout">
            <div className="layout-left"></div>
            <div className="layout-center">
                <UserInfo></UserInfo>
                <ArticleContainer></ArticleContainer>
            </div>
            <div className="layout-right"></div>
        </div>
    );
};

export default UserPage;
