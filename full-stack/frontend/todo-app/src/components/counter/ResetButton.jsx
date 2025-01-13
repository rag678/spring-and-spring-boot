export default function ResetButton({resetMethod}){
    return (
        <div>
            <button type="button" className="resetButton"
            onClick={resetMethod}
                >
                    Reset
                </button>
        </div>
    )
}