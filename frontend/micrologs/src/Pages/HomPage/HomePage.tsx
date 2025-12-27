import ArticleContainer from "../../Components/ArticleContainer/ArticleContainer";
import "./homepage.css";

const HomePage = () => {
    return (
        <div>
            <div className="home-page">
                <div className="home-left outline"></div>
                <div className="home-center">
                    <h1>MicroLogs</h1>
                    <ArticleContainer className="home-center outline"></ArticleContainer>
                </div>
                <div className="home-right outline"></div>
            </div>
        </div>
    );
};

export default HomePage;
