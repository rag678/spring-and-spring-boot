const Person = {
    name: "Anurag",
    address: {
        line1: 'Ring Road',
        city: 'Lucknow',
        country: 'India'
    },
    profiles: ["twitter", "LinkedIn", 'Instagram'],
    printProfiles: () => {
        Person.profiles.map(
            profile => console.log(profile)
        )
        console.log(Person.profiles[1]);
    }
}

export default function LearningJavaScript() {
    return (
        <>
            <div>
                {Person.name}
            </div>
            <div>
                {Person.address.line1}
            </div>
            <div>{Person.profiles[0]}</div>
            <div>{Person.printProfiles()}</div>
        </>
    )
}