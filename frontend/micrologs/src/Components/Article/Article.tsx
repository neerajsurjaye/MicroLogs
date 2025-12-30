import { useState } from "react";
import "./article.css";
import { BiDownvote, BiShare, BiUpvote, BiUser } from "react-icons/bi";
import type { ArticleType } from "../../Types/ArticleType";

type ArticleProps = {
    article: ArticleType;
};

const Article = (props: ArticleProps) => {
    const [likes, setLikes] = useState(props.article.likeCount);
    const [user, setUser] = useState(props.article.authorId);

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
                <div className="article-title">{props.article.title}</div>
                <div className="article-desc">{props.article.description}</div>
                <div className="article-body">{props.article.body}</div>
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
