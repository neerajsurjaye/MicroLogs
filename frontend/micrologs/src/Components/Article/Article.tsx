import { useState } from "react";
import "./article.css";
import { BiDownvote, BiShare, BiUpvote, BiUser } from "react-icons/bi";

const Article = () => {
    const [likes, setLikes] = useState(Math.floor(Math.random() * 100));
    const [dislikes, setDislikes] = useState(Math.floor(Math.random() * 100));
    const [user, setUser] = useState("John");

    const genSampleArticle = (n: number): string => {
        const articleContent: string[] = [];
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
            articleContent.push(
                words[Math.floor(Math.random() * words.length)]
            );
        }
        return articleContent.join(" ");
    };

    const genSampleArticleTitle = (): string => {
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

        return words[Math.floor(Math.random() * words.length)];
    };

    return (
        <>
            <div className="article">
                <div className="article-title">{genSampleArticleTitle()}</div>
                <div className="article-body">{genSampleArticle(800)}</div>
                <div className="article-details">
                    <div className="article-user btn btn-round">
                        <BiUser></BiUser>
                        {user}
                    </div>
                    <div className="article-like btn btn-round">
                        <BiUpvote></BiUpvote>
                        {likes}
                    </div>
                    <div className="article-dislike btn btn-round">
                        <BiDownvote></BiDownvote>
                        {dislikes}
                    </div>
                    <div className="article-share btn btn-round">
                        <BiShare></BiShare>
                        SHARE
                    </div>
                </div>
            </div>
        </>
    );
};

export default Article;
