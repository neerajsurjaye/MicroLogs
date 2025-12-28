import { BrowserRouter, Route, Routes } from "react-router";
import HomePage from "./Pages/HomPage/HomePage";
import Authentication from "./Pages/Authentication/Authentication";
import NavBar from "./Components/NavBar/NavBar";
import Footer from "./Components/Footer/Footer";
import ArticlePage from "./Pages/ArticlePage/ArticlePage";
import UserPage from "./Pages/UserPage/UserPage";
import CreateArticle from "./Pages/CreateArticlePage/CreateArticle";
import ScrollToTop from "./Components/ScrollToTop/ScrollToTop";
import LoginState from "./State/LoginState";
import { JWT_TOKEN, USERID, USERNAME } from "./Constants/Constants";
import { useState } from "react";
import type { UserLoginState } from "./Types/UserLoginState";

function App() {
    const [loginState, setLoginState] = useState<UserLoginState>(() => {
        return {
            username: localStorage.getItem(USERNAME),
            userid: localStorage.getItem(USERID),
            loggedin: localStorage.getItem(JWT_TOKEN) != null,
        };
    });

    return (
        <BrowserRouter>
            <LoginState.Provider value={[loginState, setLoginState]}>
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
            </LoginState.Provider>
        </BrowserRouter>
    );
}

export default App;
