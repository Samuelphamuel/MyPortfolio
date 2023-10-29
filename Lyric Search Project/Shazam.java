public class Shazam{

	final AudioFormat format = getFormat(); //Fill AudioFormat with the settings
	DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
	final TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
	line.open(format);
	line.start();
	
	private AudioFormat getFormat() {
    	float sampleRate = 44100;
    	int sampleSizeInBits = 16;
    	int channels = 1;          //mono
    	boolean signed = true;     //Indicates whether the data is signed or unsigned
    	boolean bigEndian = true;  //Indicates whether the audio data is stored in big-endian or little-endian order
    	return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}


	OutputStream out = new ByteArrayOutputStream();
	running = true;

	try {
    	while (running) {
        	int count = line.read(buffer, 0, buffer.length);
        	if (count > 0) {
            	out.write(buffer, 0, count);
        	}
    	}
    	out.close();
	} catch (IOException e) {
    	System.err.println("I/O problems: " + e);
    	System.exit(-1);
	}

	byte audio [] = out.toByteArray()
	int totalSize = audio.length
	int sampledChunkSize = totalSize/chunkSize;
	Complex[][] result = ComplexMatrix[sampledChunkSize][];

	for(int j = 0;i < sampledChunkSize; j++) {
  	Complex[chunkSize] complexArray;

  	for(int i = 0; i < chunkSize; i++) {
    	complexArray[i] = Complex(audio[(j*chunkSize)+i], 0);
  	}

  	result[j] = FFT.fft(complexArray);


} //end method



} //end main

// Class that represents specific moment in a song
private class DataPoint {

    private int time;
    private int songId;

    public DataPoint(int songId, int time) {
        this.songId = songId;
        this.time = time;
    }
    
    public int getTime() {
        return time;
    }
    public int getSongId() {
        return songId;
    }
}