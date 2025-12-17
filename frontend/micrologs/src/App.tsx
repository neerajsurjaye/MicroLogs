import { BrowserRouter, Route, Routes } from "react-router";
import HomePage from "./Pages/HomPage/HomePage";
import Authentication from "./Pages/Authentication/Authentication";
import NavBar from "./Components/NavBar/NavBar";
import Footer from "./Components/Footer/Footer";

function App() {
    return (
        <BrowserRouter>
            <NavBar></NavBar>
            <Routes>
                <Route path="/" Component={HomePage}></Route>
                <Route path="/auth" Component={Authentication}></Route>
            </Routes>
            <Footer></Footer>
        </BrowserRouter>
    );
}

export default App;
