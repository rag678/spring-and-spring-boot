
import { PropTypes } from 'prop-types'

export default function CounterButton({ by, incrementMethod, decrementMethod }) {

    return (
        <div className="Counter">
            <div>
                <button type="button" className="counterButton"
                    onClick={() => decrementMethod(by)}
                >
                    -{by}
                </button>
                <button type="button" className="counterButton"
                    onClick={() => incrementMethod(by)}
                >
                    +{by}
                </button>
            </div>
        </div>
    )
}

CounterButton.propTypes = {
    by: PropTypes.number
};

CounterButton.defaultProps = {
    by: 2
}