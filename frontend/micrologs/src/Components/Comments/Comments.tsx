import SingleComment from "../SingleComment/SingleComment";
import "./comments.css";

const Comments = () => {
    const generateComments = (n: number) => {
        const comments: React.ReactElement[] = [];

        const users = ["john", "doe", "adam", "joey"];
        const words = [
            "apple",
            "river",
            "cloud",
            "engine",
            "shadow",
            "pixel",
            "forest",
            "signal",
            "quantum",
            "ember",
        ];

        for (let i: number = 0; i < n; i++) {
            const user = users[Math.floor(Math.random() * users.length)];
            const comment: string[] = [];
            for (let j: number = 0; j < Math.random() * 1000; j++) {
                comment.push(words[Math.floor(Math.random() * words.length)]);
            }

            comments.push(
                <SingleComment
                    user={user}
                    comment={comment.join(" ")}
                    likes={Math.floor(Math.random() * 100) + ""}
                    dislikes={Math.floor(Math.random() * 100) + ""}
                    commentid={i}
                ></SingleComment>
            );
        }

        return comments;
    };

    return (
        <div className="comments-container outline">
            <div className="comments-title">Comments</div>
            <div className="comments">{generateComments(10)}</div>
        </div>
    );
};

export default Comments;
