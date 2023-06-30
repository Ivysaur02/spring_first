import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:url_launcher/url_launcher.dart';

String imageUrlGl = 'https://example.com/image1.jpg';
const Color darkBlue = Color.fromARGB(255, 18, 32, 47);

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
    runApp(const MyApp());
  //runApp(MyHomePage());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        theme: ThemeData.dark().copyWith(scaffoldBackgroundColor: darkBlue),
        debugShowCheckedModeBanner: false,
        home: Scaffold(body: Center(child: MyHomePage())));
  }
}
//видже открываюший гифку в браузере/отдельном окне
class MyWidget extends StatelessWidget {
  const MyWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Column( children:[MyHomePage(),Container(
        width: 370,
        height: 100,
        padding: const EdgeInsets.all(20.0),
        decoration: BoxDecoration(
            gradient: const LinearGradient(
                begin: Alignment.topLeft,
                end: Alignment.topRight,
                colors: [Colors.deepOrange, Colors.greenAccent]),
            borderRadius: BorderRadius.circular(15)),
        child: ElevatedButton(
            style: ButtonStyle(
                shape: MaterialStateProperty.all(RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(15.0),
                    side: const BorderSide(color: darkBlue))),
                overlayColor: MaterialStateProperty.all(darkBlue),
                backgroundColor: MaterialStateProperty.all(Colors.white),
                shadowColor: MaterialStateProperty.all(darkBlue)),
            onPressed: () async {
              final url = Uri.http(
                'localhost:8080',
                '/quotation',
                {'q': '{http}'},
              );
              //final url = Uri.http('http://localhost:8080/quotation');
              // Await the HTTP GET response, then decode the
              // JSON data it contains.
              final response = await http.get(url);

              if (response.statusCode == 200) {
                //final jsonResponse = convert.jsonDecode(response.body);
                //final itemCount = jsonResponse['totalItems'];

                //debugPrint('Number of books about HTTP: ${response.body}.');
                var str = ('${response.body}.').split('-').last;
                var str2 = 'https://i.giphy.com/media/' + str.substring(0, str.length - 1) + '/200.gif';
                //debugPrint(str);
                //debugPrint(str2);
                final urlGif = Uri.parse(str2);
                //debugPrint(urlGif.toString());
                //launchUrl(urlGif);
                imageUrlGl = urlGif.toString();
                //Image.network(imageUrlGl);
                } else {
                debugPrint(
                    'Request failed with status: ${response.statusCode}.');
              }
              // debugPrint('Button Clicked');
            },
            child: const Text('Состояние курса рубля',
                style: TextStyle(fontSize: 26, color: Colors.black))))
        ]
  );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String rubState = "undefined";
  Color rubStateColor = Colors.black;
  String imageUrl =
      'https://media0.giphy.com/media/df2hrDO6GYorzi5AxQ/200w.webp?cid=ecf05e47hxv7lyujzdily2g2ymfprlbp4lipjdn93fesatyr&ep=v1_gifs_search&rid=200w.webp&ct=g';
  void changeImage() {
    setState(() {
      imageUrl = imageUrlGl; // Новая картинка
    });
  }
  @override
  Widget build(BuildContext context) {
    //launchUrl(Uri.parse(imageUrl));
    return  //Image.network(imageUrl); 
    Column(mainAxisAlignment: MainAxisAlignment.spaceAround ,children:[
      Container(
        width: 370,
        height: 400,
        padding: const EdgeInsets.all(20.0),
        decoration:  BoxDecoration(
            gradient:const LinearGradient(
                begin: Alignment.topLeft,
                end: Alignment.topRight,            
                stops: [0.1, 0.35, 0.6, 0.9,],
              colors: [
                Color.fromARGB(255, 100, 207, 243),
                Color.fromARGB(255, 43, 116, 150),
                Color.fromARGB(255, 34, 59, 124),
                Color.fromARGB(255, 18, 33, 81)
                ]), 
              borderRadius: BorderRadius.circular(15.0)),
        child: Image.network(imageUrl)
      ),
      Text(rubState,
          style: TextStyle(color: rubStateColor, fontSize: 24)
      ),
      Container(
        width: 370,
        height: 100,
        padding: const EdgeInsets.all(20.0),
        decoration: BoxDecoration(
            gradient: const LinearGradient(
                begin: Alignment.topLeft,
                end: Alignment.topRight,
                colors: [Colors.deepOrange, Colors.greenAccent]),
            borderRadius: BorderRadius.circular(15)),
        child: ElevatedButton(
            style: ButtonStyle(
                shape: MaterialStateProperty.all(RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(15.0),
                    side: const BorderSide(color: darkBlue))),
                overlayColor: MaterialStateProperty.all(darkBlue),
                backgroundColor: MaterialStateProperty.all(Colors.white),
                shadowColor: MaterialStateProperty.all(darkBlue)),
            onPressed: () async {
              final url = Uri.http(
                '10.0.2.2:8080',
                '/quotation',
                {'q': '{http}'},
              );
              //final urlDecstop = Uri.http(
              //  'localhost:8080',
              //  '/quotation',
              //  {'q': '{http}'},
              //);
              final response = await http.get(url);

              if (response.statusCode == 200) {
                //debugPrint('HTTP: ${response.body}.');
                var str = ('${response.body}.').split('-').last;
                rubState = ('${response.body}.').split(' ').first;
                if (rubState=='rich'){rubStateColor = Colors.greenAccent;}
                else {rubStateColor = Colors.deepOrange;}
                var str2 = 'https://i.giphy.com/media/' + str.substring(0, str.length - 1) + '/200.gif';
                //debugPrint(str);
                final urlGif = Uri.parse(str2);
                //launchUrl(urlGif);
                imageUrlGl = urlGif.toString();
                changeImage();
                //Image.network(imageUrlGl);
                } else {
                debugPrint(
                    'Request failed with status: ${response.statusCode}.');
              }
              // debugPrint('Button Clicked');
            },
            child: const Text('Состояние курса рубля',
                style: TextStyle(fontSize: 26, color: Colors.black))))
        ]);
  
  }
}


