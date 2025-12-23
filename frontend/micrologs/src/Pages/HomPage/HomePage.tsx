import ArticleContainer from "../../Components/ArticleContainer/ArticleContainer";
import NotificationContainer from "../../Components/NotificationContainer/NotificationContainer";
import "./homepage.css";

const HomePage = () => {
    return (
        <div>
            <div className="home-page">
                <div className="home-left outline"></div>
                <ArticleContainer className="home-center outline"></ArticleContainer>
                <div className="home-right outline"></div>
            </div>
        </div>
    );
};

export default HomePage;
