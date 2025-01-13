import { useContext } from "react"
import { AuthContext } from "./security/AuthContext"

export default function FooterComponent() {
    const authContext = useContext(AuthContext)
        console.log( `Footer Context - ${authContext.number}`)
    return (
        <footer className="header">
            <div className="container">
                Your Footer - Email
            </div>
        </footer>
    )
}