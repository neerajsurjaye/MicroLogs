import Article from "../../Components/Article/Article";
import Comments from "../../Components/Comments/Comments";
import "./articlePage.css";

const ArticlePage = () => {
    return (
        <div className="article-page">
            <div className="article-left outline"></div>
            <div className="article-center outline">
                <Article></Article>
                <Comments></Comments>
            </div>
            <div className="article-right outline"></div>
        </div>
    );
};

export default ArticlePage;
