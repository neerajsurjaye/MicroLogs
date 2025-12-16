import ArticleContainer from "../../Components/ArticleContainer/ArticleContainer";
import NavBar from "../../Components/NavBar/NavBar";
import "./homepage.css";

const HomePage = () => {
    return (
        <div>
            <NavBar></NavBar>
            <div className="home-page">
                <div className="home-left outline"></div>
                <ArticleContainer className="home-center outline"></ArticleContainer>
                <div className="home-right outline"></div>
            </div>
        </div>
    );
};

export default HomePage;
