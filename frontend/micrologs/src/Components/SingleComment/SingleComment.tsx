import "./SingleComment.css";

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
            <div className="comment-user">{props.user}</div>
            <div className="comment-content">{props.comment}</div>
            <div className="comment-votes-container">
                <div className="comment-likes btn btn-rounded">
                    Like : {props.likes}
                </div>
                <div className="comometn-dislikes btn btn-rounded">
                    Dislike : {props.dislikes}
                </div>
            </div>
        </div>
    );
};

export default SingleComment;
