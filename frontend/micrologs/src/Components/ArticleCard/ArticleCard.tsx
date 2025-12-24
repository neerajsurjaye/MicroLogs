import { Link } from "react-router";
import "./ArticleCard.css";
import { BiDownvote, BiUpvote } from "react-icons/bi";

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
                <div className="article-card-title">
                    <h2>{props.title}</h2>
                    <div className="article-user">-- {props.user}</div>
                </div>
                <p>{props.desc}</p>
                <div className="article-card-details">
                    <div className="article-likes btn">
                        <BiUpvote></BiUpvote>
                        {props.likes}
                    </div>
                    <div className="article-dislikes btn">
                        <BiDownvote></BiDownvote>
                        {props.dislikes}
                    </div>
                </div>
            </Link>
        </div>
    );
};

export default ArticleCard;
