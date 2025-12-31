import { useParams } from "react-router";
import Article from "../../Components/Article/Article";
import Comments from "../../Components/Comments/Comments";
import "./articlePage.css";
import ArticleService from "../../Service/ArticleService";
import { useEffect, useState } from "react";
import type { ArticleType } from "../../Types/ArticleType";

const ArticlePage = () => {
    const { slug } = useParams<{ slug: string }>();
    const [article, setArticle] = useState<ArticleType | null>(null);

    const fetchArticle = async () => {
        if (slug != null && slug != "") {
            setArticle(await ArticleService.fetchArticle(slug));
        }
    };

    useEffect(() => {
        fetchArticle();
    }, []);

    return (
        <div className="article-page">
            <div className="article-left outline"></div>
            <div className="article-center outline">
                {article == null ? (
                    <div className="loading">Loading</div>
                ) : (
                    <Article article={article}></Article>
                )}

                <Comments></Comments>
            </div>
            <div className="article-right outline"></div>
        </div>
    );
};

export default ArticlePage;
