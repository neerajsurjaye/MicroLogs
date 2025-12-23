import "./article.css";

const Article = () => {
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

    return (
        <>
            <div className="article">
                <div className="article-title">Title</div>
                <div className="article-body">{genSampleArticle(800)}</div>
                <div className="article-details">
                    <div className="article-user btn btn-round">USER</div>
                    <div className="article-like btn btn-round">Like</div>
                    <div className="article-dislike btn btn-round">DISLIKE</div>
                    <div className="article-share btn btn-round">SHARE</div>
                </div>
            </div>
        </>
    );
};

export default Article;
