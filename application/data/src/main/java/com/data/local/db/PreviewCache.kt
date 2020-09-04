package com.data.local.db

import android.content.Context
import android.os.AsyncTask
import com.data.local.db.dao.PreviewDao
import com.data.local.db.entity.PreviewEntity
import io.reactivex.Observable

class PreviewCache(context: Context) {

    private val database = DatabaseBuilder.getAppDatabase(context)
    private val accessPreview = database.previewDao()

    fun addAll(vararg previews: PreviewEntity) {
        Thread {
            accessPreview.addAll(*previews)
        }.start()

    }

    fun delete(previews: PreviewEntity) {
        Thread {
            accessPreview.delete(previews)
        }.start()
    }

    fun update(previews: PreviewEntity) {
        Thread {
            accessPreview.update(previews)
        }.start()
    }

    fun getAll(callback: (list: List<PreviewEntity>) -> Unit) {
        GetAllAsync(accessPreview, callback).execute()
    }

    fun getAllObservableSync(): Observable<List<PreviewEntity>> {
        return Observable.just(accessPreview.getAll())
    }

    fun getAllWithThread(callback: (list: List<PreviewEntity>) -> Unit){
        Thread {
            val list = accessPreview.getAll()
            callback(list)
        }.start()
    }
}

class GetAllAsync(
    private val previewDao: PreviewDao,
    private val callback: (list: List<PreviewEntity>) -> Unit
) : AsyncTask<Void, Void, List<PreviewEntity>>() {

    override fun doInBackground(vararg params: Void?): List<PreviewEntity> {
        return previewDao.getAll()
    }

    override fun onPostExecute(result: List<PreviewEntity>) {
        super.onPostExecute(result)
        callback(result)
    }

}