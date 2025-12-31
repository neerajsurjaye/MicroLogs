import { useEffect, useState } from "react";
import ArticleContainer from "../../Components/ArticleContainer/ArticleContainer";
import "./homepage.css";
import ArticleService from "../../Service/ArticleService";
import type { ArticleType } from "../../Types/ArticleType";

const HomePage = () => {
    const [articles, setArticles] = useState<ArticleType[]>([]);

    const fetchArticles = async () => {
        let fetchedArticles = await ArticleService.fetchHomePage();
        setArticles(fetchedArticles);
        console.log({ fetchedArticles });
    };

    useEffect(() => {
        fetchArticles();
    }, []);

    return (
        <div>
            <div className="home-page">
                <div className="home-left outline"></div>
                <div className="home-center">
                    <h1>MicroLogs</h1>
                    {articles.length == 0 ? (
                        <div className="loader">Loading</div>
                    ) : (
                        <ArticleContainer
                            className="home-center outline"
                            article={articles}
                        ></ArticleContainer>
                    )}
                </div>
                <div className="home-right outline"></div>
            </div>
        </div>
    );
};

export default HomePage;
