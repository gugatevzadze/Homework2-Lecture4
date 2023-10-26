package com.example.homework2_lecture4

fun numberConverter(number:Int): String {

    //ამ მასივების შედგენაზე ტვინი გამეღუნა
    val oneDigits = arrayOf("","ერთი","ორი","სამი","ოთხი","ხუთი","ექვსი","შვიდი","რვა","ცხრა")
    val twoDigits = arrayOf("ათი","თერთმეტი","თორმეტი","ცამეტი","თოთხმეტი","თხუთმეტი","თექვსმეტი","ჩვიდმეტი","თვრამეტი","ცხრამეტი")
    val tens = arrayOf("ოც","ორმოც","სამოც","ოთხმოც")
    val hundreds = arrayOf("ას","ორას","სამას","ოთხას","ხუთას","ექვსას","შვიდას","რვაას","ცხრაას")

    return when{
        //ვიცი რომ 1-დან 1000-მდე იყო მაგრამ მაინც ჩავწერე
        number == 0 ->{
            "0-ზე (ნულზე) არ ვიცოდი რა მექნა, ღამე იყო და ვეღარ ვიკითხე ;დ"
        }
        number < 10 -> {
            oneDigits[number]
        }
        number < 20 -> {
            twoDigits[number - 10]
        }
        //რადგან ქართული ბეის 20 ენა არის, ეს ძალიან მახინჯი ადგილია
        number < 100 -> {
            val forTens = ((number/10)/2)-1 //tens მასივში ბეის ოცი ციფრის მოსაძებნად
            val forOnes = number % 10 //მეორე ციფრისთვის
            if(number % 20 >= 10){ //ბეოს ოცს + 10-ზე მეტი ციფრების დასაწერად
                tens[forTens] +"და"+ twoDigits[forOnes]
            }else if(number % 20 == 0){//ბეის ოცს + 'ი'
                tens[forTens] +"ი"
            }else{
                tens[forTens] +"და"+ oneDigits[forOnes]//დანარჩნი ციფრების დასაწერად
            }
        }
        //აქ უკვე რეკურსიას ვიყენებ, 100-ზე ნაკლები ციფრების კოდი როარ გამემეორებინა რეკურსიულად ამოხსნა ვამჯობინე
        number < 1000 -> {
            val forHundreds = (number / 100) - 1//hundreds მასივში ასეულის ციფრის მოსაძებნად
            val remainder = number % 100
            val forTensTwo = numberConverter(remainder) //ვიმეორებ 100ზე ნაკლები ციფრების ოპერაციებს
            if (number % 100 == 0) {//ზუსტად ასეულები
                hundreds[forHundreds] + "ი"
            } else {
                hundreds[forHundreds] + " " + forTensTwo//ყველა დანარჩენი
            }
        }
        else -> {"სასაცილო ტექსტი"}
    }
}