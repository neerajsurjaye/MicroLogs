import { BrowserRouter, Route, Routes } from "react-router";
import HomePage from "./Pages/HomPage/HomePage";
import Authentication from "./Pages/Authentication/Authentication";
import NavBar from "./Components/NavBar/NavBar";
import Footer from "./Components/Footer/Footer";
import ArticlePage from "./Pages/ArticlePage/ArticlePage";

function App() {
    return (
        <BrowserRouter>
            <NavBar></NavBar>
            <div className="page">
                <Routes>
                    <Route path="/" Component={HomePage}></Route>
                    <Route path="/auth" Component={Authentication}></Route>
                    <Route path="/article" Component={ArticlePage}></Route>
                </Routes>
            </div>
            <Footer></Footer>
        </BrowserRouter>
    );
}

export default App;
