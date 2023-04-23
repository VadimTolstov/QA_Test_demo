package hw_8.utils;

//import com.github.javafaker.Faker;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//import java.util.Map;
//
//public class DataGeneratorFallingVersion {
//
//    public static StudentData getRandomStudent() {
//        Faker faker = new Faker(new Locale("en"));
//
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//        String userEmail = faker.internet().emailAddress();
////        String[] arrGenders = {"Male", "Female", "Other"};
////        String gender = getRndValueArr(arrGenders);
//        String gender = faker.options().option("Male", "Female", "Other");
////        String[] arrHobby = {"Sports", "Reading", "Music"};
////        String hobby = getRndValueArr(arrHobby);
//        String hobby = faker.options().option("Sports", "Reading", "Music");
////        String[] arrSubjects = {"Maths", "English", "Chemistry", "Arts", "Civics", "Hindi", "History", "Physics"};
////        String subject = getRndValueArr(arrSubjects);
//        String subject = faker.options().option("Maths", "English", "Chemistry", "Arts", "Civics", "Hindi", "History", "Physics");
//        String userPhone = faker.phoneNumber().subscriberNumber(10);
//        // Получаем др,
////        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
////        String data = sdf.format(faker.date().birthday());
////        String day = data.trim().substring(0, 2);
////        int x = data.indexOf(' ');
////        int i = data.indexOf(',');
////        String month = data.substring(x + 1, i);
////        String year = data.substring(i + 1);
//
//        Date fakerDate = faker.date().birthday();
//
//        SimpleDateFormat sdfDay = new SimpleDateFormat("d", Locale.ENGLISH);
//        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
//        SimpleDateFormat sdfYear = new SimpleDateFormat("y", Locale.ENGLISH);
//
//        String month = sdfMonth.format(fakerDate);
//        String year = sdfYear.format(fakerDate);
//        String day = sdfDay.format(fakerDate);
//
//
//        String filePath = "pictures/JAVA_20.6_10.jpg";
//        String address = faker.address().fullAddress();
//
//        var mapStateWithCity = Map.of(
//                "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
//                "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
//                "Haryana", new String[]{"Karnal", "Panipat"},
//                "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
//        );
//
////        String state = getRndValueArr(mapStateWithCity.keySet().toArray(new String[0])); // Выбран случайный штат
////        String city = getRndValueArr(mapStateWithCity.get(state)); // Выбран случайный город штата выше
//
//        String state = (String) faker.options().option(mapStateWithCity.keySet().toArray()); // Выбран случайный штат
//        String city = faker.options().option(mapStateWithCity.get(state)); // Выбран случайный город штата выше
//
//        return new StudentData()
//                .thisFirstName(firstName)
//                .thisLastName(lastName)
//                .thisUserEmail(userEmail)
//                .thisGender(gender)
//                .thisUserPhone(userPhone)
//                .thisHobby(hobby)
//                .thisSubject(subject)
//                .thisDay(day)
//                .thisMonth(month)
//                .thisYear(year)
//                .thisFilePath(filePath)
//                .thisAddress(address)
//                .thisState(state)
//                .thisCity(city);
//    }
//
////    public static String getRndValueArr(String[] arr) {
////        int rnd = new Random().nextInt(arr.length);
////        return arr[rnd];
////    }
//
//
//
//}
//
