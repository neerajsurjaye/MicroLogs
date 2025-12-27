import { Link } from "react-router";
import "./SingleComment.css";
import { BiDownvote, BiUpvote } from "react-icons/bi";

type commentProps = {
    user: string;
    comment: string;
    likes: string;
    dislikes: string;
    commentid: number;
};

const SingleComment = (props: commentProps) => {
    return (
        <div className="single-comment outline">
            <div className="comment-user">
                <Link to={"/user"}>{props.user}</Link>
            </div>
            <div className="comment-content">{props.comment}</div>
            <div className="comment-votes-container">
                <div className="comment-likes btn btn-rounded btn-no-back">
                    <BiUpvote></BiUpvote>
                    {props.likes}
                </div>
                <div className="comometn-dislikes btn btn-rounded btn-no-back">
                    <BiDownvote></BiDownvote>
                    {props.dislikes}
                </div>
            </div>
        </div>
    );
};

export default SingleComment;
