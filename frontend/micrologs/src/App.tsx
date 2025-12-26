import { BrowserRouter, Route, Routes } from "react-router";
import HomePage from "./Pages/HomPage/HomePage";
import Authentication from "./Pages/Authentication/Authentication";
import NavBar from "./Components/NavBar/NavBar";
import Footer from "./Components/Footer/Footer";
import ArticlePage from "./Pages/ArticlePage/ArticlePage";
import UserPage from "./Pages/UserPage/UserPage";
import CreateArticle from "./Pages/CreateArticlePage/CreateArticle";
import ScrollToTop from "./Components/ScrollToTop/ScrollToTop";

function App() {
    return (
        <BrowserRouter>
            <ScrollToTop></ScrollToTop>
            <NavBar></NavBar>
            <div className="page">
                <Routes>
                    <Route path="/" Component={HomePage}></Route>
                    <Route path="/auth" Component={Authentication}></Route>
                    <Route path="/article" Component={ArticlePage}></Route>
                    <Route path="/user" Component={UserPage}></Route>
                    <Route path="/create" Component={CreateArticle}></Route>
                </Routes>
            </div>
            <Footer></Footer>
        </BrowserRouter>
    );
}

export default App;
