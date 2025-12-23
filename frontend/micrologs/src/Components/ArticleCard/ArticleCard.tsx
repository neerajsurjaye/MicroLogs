import { Link } from "react-router";
import "./ArticleCard.css";

const ArticleCard = () => {
    return (
        <div className="article-card outline">
            <Link to={"/article"}> Article Card</Link>
        </div>
    );
};

export default ArticleCard;
