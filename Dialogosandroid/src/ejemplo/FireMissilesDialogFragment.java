package ejemplo;

import java.util.List;

import mx.com.gm.dialogosandroid.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

public class FireMissilesDialogFragment extends DialogFragment {

	List<Integer> mSelectedItems = null;

	public interface FireMissilesDialogListener {

		public void OnDialogPositiveClick(FireMissilesDialogFragment obj);

		public void OnDialogNegativeClick(FireMissilesDialogFragment obj);		
		
	}

	FireMissilesDialogListener mListener;

	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);

		try {
			mListener = (FireMissilesDialogListener) activity;

		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeDialogListener");
		}
	}
	

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		final LayoutInflater inflater = getActivity().getLayoutInflater();	
		

		builder.setTitle("Datos de Acceso")
				.setIcon(R.drawable.ic_launcher)
				.setMessage("Introduce tu Password")
				.setView(inflater.inflate(R.layout.dialogo_personalizado, null))
				.setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {						
						mListener.OnDialogPositiveClick(FireMissilesDialogFragment.this);						
					}
				})	
				
				.setNegativeButton(R.string.cambiar, new DialogInterface.OnClickListener() { 
					public void onClick(DialogInterface dialog, int id) { // User cancelled the
						mListener.OnDialogNegativeClick(FireMissilesDialogFragment.this);
					} 
				});
				
						
		
		return builder.create();
	}
}