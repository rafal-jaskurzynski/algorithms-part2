
import java.util.ArrayList;

import edu.princeton.cs.algs4.In;

public class WordNet {

	class InputData {
		int id;
		String synset;
		String[] hypernyms;

		public String toString() {
			String str = String.valueOf(id) + ":" + synset;
			
			for(String s : hypernyms)
			{
				str += s + ",";
			}
			
			return str;
		}
	};

	ArrayList<InputData> _inputData;

	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) {
		if (synsets == null)
			throw new IllegalArgumentException("Illegal Argument Exception");
		if (hypernyms == null)
			throw new IllegalArgumentException("Illegal Argument Exception");

		ArrayList<InputData> _inputData = new ArrayList<InputData>();

		In inSynsets = new In(synsets);
		
		String line;
		while ((line = inSynsets.readLine()) != null) {
			
			String[] splitedLine = line.split(",");

			if (splitedLine.length < 2) {
				throw new IllegalArgumentException("Invalid input");
			}

			InputData row = new InputData();
			row.id = Integer.parseInt(splitedLine[0]);
			row.synset = splitedLine[1];
			_inputData.add(row);

			System.out.println(line);
		}

		In inHypernyms = new In(hypernyms);

		while ((line = inHypernyms.readLine()) != null) {
			String[] splitedLine = line.split(",");
			int id = Integer.parseInt(splitedLine[0]);
			
			_inputData.get(id).hypernyms = splitedLine;
		}
		
		System.out.println("size: " + _inputData.size());
		System.out.println(_inputData.get(4));
	}

	// returns all WordNet nouns
	public Iterable<String> nouns() {
		return null;
	}

	// is the word a WordNet noun?
	public boolean isNoun(String word) {
		return true;
	}

	// distance between nounA and nounB (defined below)
	public int distance(String nounA, String nounB) {
		return 0;
	}

	// a synset (second field of synsets.txt) that is the common ancestor of nounA
	// and nounB
	// in a shortest ancestral path (defined below)
	public String sap(String nounA, String nounB) {
		return "";
	}

	// do unit testing of this class

	public static void main(String[] args) {
		System.out.println("WordNet");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}

		if (args.length != 2) {
			System.out.println("Please provide valid args");
			return;
		}

		WordNet wordnet = new WordNet(args[0], args[1]);

	}
}
