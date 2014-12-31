package rubinstein.paint.message;

import java.util.Scanner;

import rubinstein.paint.Canvas;

public class PaintMessageFactory {
	private Canvas canvas;
	
	public PaintMessageFactory(Canvas canvas){
		this.canvas = canvas;
	}
	public PaintMessage getMessage(String message){
		Scanner scanner = new Scanner(message);
		
		String messageType = scanner.next();
		
		
		switch(messageType){
		case "LINE":
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			int color = scanner.nextInt();
			int stroke = scanner.nextInt();
			return new PencilMessage(x1, y1, x2, y2, color, stroke);
		case "SHAPE":
			String type = scanner.next();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int width = scanner.nextInt();
			int height = scanner.nextInt();
			int color2 = scanner.nextInt();
			int stroke2 = scanner.nextInt();
			boolean fill = Boolean.valueOf(scanner.next());
			return new ShapeMessage(type, x, y, width, height, color2, stroke2, fill);
		case "CLEAR":
			break;
		case "BUCKET_FILL":
			int X = scanner.nextInt();
			int Y = scanner.nextInt();
			int color3 = scanner.nextInt();
			return new BucketFillMessage(canvas, X, Y, color3);
			
		}
		return null;
	}

}
