package p01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashSet;

public class SaveDAO {
	public static void saveData() throws IOException{
		String fileName = "./data/petData.txt"; //저장할 txt파일
		try {
			File file = new File(fileName);
			OutputStream ops = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(ops);
			oos.writeObject(petHotel.petSet);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void returnData() {
		String fileName = "./data/petData.txt"; //저장할 txt파일
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object object = ois.readObject();
			ois.close();
			HashSet<Pet> petSave = (HashSet<Pet>)object;
			petHotel.petSet = petSave;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
