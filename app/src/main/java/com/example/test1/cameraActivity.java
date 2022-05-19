package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;


public class cameraActivity extends AppCompatActivity {
    /*final String TAG= getClass().getSimpleName();
    Button btn_photo;
    ImageView iv_photo;

    final static int TAKE_PICTURE=1;

    String mCurrentPhotoPath;
    final static int REQUEST_TAKE_PHOTO=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //레이아웃과 변수 연결
        iv_photo = findViewById(R.id.imageView);
        btn_photo = findViewById(R.id.button);
        //카메라 버튼에 리스너 추가
        btn_photo.setOnClickListener((View.OnClickListener) this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "권한 설정 완료");
            } else {
                Log.d(TAG, "권한 설정 요청");
                ActivityCompat.requestPermissions(cameraActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

            }
        }

        @Override
        public void onClick(View v){
            switch (v.getId()) {
                case R.id.button:
                    dispatchTakePictureIntent();
                    break;
            }
        }


        // 권한 요청
        @Override
        public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            Log.d(TAG, "onRequestPermissionsResult");
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
            }
        }
        // 카메라로 촬영한 영상을 가져오는 부분
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent intent){
            super.onActivityResult(requestCode, resultCode, intent);
            try {
                switch (requestCode) {
                    case REQUEST_TAKE_PHOTO: {
                        if (resultCode == RESULT_OK) {
                            File file = new File(mCurrentPhotoPath);
                            Bitmap bitmap;
                            if (Build.VERSION.SDK_INT >= 29) {
                                ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(), Uri.fromFile(file));
                                try {
                                    bitmap = ImageDecoder.decodeBitmap(source);
                                    if (bitmap != null) {
                                        iv_photo.setImageBitmap(bitmap);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file));
                                    if (bitmap != null) {
                                        iv_photo.setImageBitmap(bitmap);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        break;
                    }
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        }
        // 사진 촬영 후 썸네일만 띄워줌. 이미지를 파일로 저장해야 함
        private File createImageFile () throws IOException {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File image = File.createTempFile(imageFileName, ".jpg", storageDir);
            mCurrentPhotoPath = image.getAbsolutePath();
            return image;
        } // 카메라 인텐트 실행하는 부분
        private void dispatchTakePictureIntent() {
            android.content.Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                }
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(this, "com.example.test1", photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                }
            }
        }
    }
}



/*public class cameraActivity extends AppCompatActivity {

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageView = findViewById(R.id.imageView);

        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(v -> takePicture());
    }

    //사진찍기
    public void takePicture(){
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(imageTakeIntent.resolveActivity(getPackageManager())!=null){
            setResult(REQUEST_IMAGE_CODE,imageTakeIntent);
        }
    }
//결과값 가져오기

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode == REQUEST_IMAGE_CODE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    }*/

}