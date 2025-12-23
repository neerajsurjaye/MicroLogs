import { Link } from "react-router";
import "./ArticleCard.css";

type articleProps = {
    title: string;
    desc: string;
    likes: number;
    dislikes: number;
    user: string;
};

const ArticleCard = (props: articleProps) => {
    return (
        <div className="article-card outline">
            <Link to={"/article"}>
                <h2>{props.title}</h2>
                <p>{props.desc}</p>
                <div className="article-details">
                    <div className="article-likes btn">{props.likes}</div>
                    <div className="article-dislikes btn">{props.dislikes}</div>
                    <div className="article-user">{props.user}</div>
                </div>
            </Link>
        </div>
    );
};

export default ArticleCard;
