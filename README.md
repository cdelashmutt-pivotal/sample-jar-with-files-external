Sample JAR with External Files
--

This project provides an example of how to package up a Java Application using the DistZip style packaging to include additional files with the application outside of the JAR file itself.

To build this example, clone the project, cd to the directory you cloned to and issue the following command:
```commandline
$ ./gradlew distZip
```
and then call:
```commandline
$ cf push
```

If you want to understand how this works, crack open the generated ZIP file in the `build/distributions` folder.

The ZIP file has a layout like the following:
```commandline
+---some-root-folder
    |   an-included-file.txt
    |
    +---bin
    |   |   linux-launch-script
    |
    +---lib
    |   | sample-jar-with-files-external-0.0.1-SNAPSHOT.jar
    |   | <all other dependent jars>
```

In this format, all the jars for the app are placed under the `lib` folder, any launcher scripts needed for the app are put under the `bin` folder, and any other included files are placed in the folder off the root of the archive.