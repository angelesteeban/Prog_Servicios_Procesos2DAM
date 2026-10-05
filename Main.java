// Ángel Esteban Parra

void main() {

    String userDir = "";
    String userOS = System.getProperty("os.name");
    System.out.println("Sistema operativo: "+ userOS);
    String command = "";

    if (userOS.equalsIgnoreCase("Linux")){
        command = "sh -c ls";
        userDir = "/tmp";

    }else if (userOS.equalsIgnoreCase("Windows")){
        command = "cmd /c dir";
        userDir = "c:/temp";
    }
    try {
        //el comando que se ejecutará en el proceso el cual depende de los ifs de arriba
        ProcessBuilder pBuilder = new ProcessBuilder(command.split("\\s"));
        pBuilder.directory(new File(userDir));
        //crear proceso
        Process process = pBuilder.start();

        //mostrar
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        reader.lines().forEach(System.out::println);

    } catch (Exception e) {
        e.printStackTrace();
    }


}
